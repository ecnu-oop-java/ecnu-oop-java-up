# I/O

## 文件 I/O

在 Java 中，文件读写常用“字节流”完成。

最基础的做法是使用 `FileInputStream` 逐字节读取文件内容，通过循环调用 `read()` 或 `read(byte[])` 获取数据；读取过程中可以一边累加读到的字节数（得到 `bytes`），一边在遇到换行符 `'\n'` 时将行数 `lines` 加一。

由于 `FileInputStream` 每次读取都可能触发较多底层 I/O 调用，性能通常不够理想，因此可以用 `BufferedInputStream` 对其进行包装。`BufferedInputStream` 会在内存中维护一块缓冲区，一次性从磁盘读入较多数据，再在内存中分发给程序，从而显著减少系统调用次数，通常能带来明显的性能提升。

为了公平比较两者读写性能，需要在同一台机器、同一份输入文件上分别运行不带缓冲和带缓冲的版本，并使用 `System.nanoTime()` 或 `System.currentTimeMillis()` 记录耗时；为降低偶然波动，建议重复运行多次（例如 `--repeat 5`）并取平均耗时，再计算加速比 `speedup = no_buffer_avg / buffered_avg`。

## 网络 I/O

网络下载本质上是“从网络输入流读取数据，再写入本地文件输出流”。

在 Java 中可以使用 `java.net.URL` 创建下载地址对象，并通过 `openStream()` 直接获得网络输入流（其内部会自动建立连接）。拿到输入流后，需要把数据写入本地文件：最基础的方式是用 `FileOutputStream` 写出字节；为了提升写入效率，可以再用 `BufferedOutputStream` 包装输出流，使写入操作先进入内存缓冲区，累积到一定大小再批量落盘。

实际拷贝数据时通常不会一次只读一个字节，而是使用字节数组作为缓冲区，例如 `byte[] buf = new byte[8192];`，在循环中不断执行 `n = in.read(buf)` 并调用 `out.write(buf, 0, n)`，直到读完为止。

为了做性能对比，需要实现两种版本：一种不使用缓冲包装（直接用输入流/输出流），另一种使用 `BufferedInputStream + BufferedOutputStream`；并记录每次下载总耗时，计算平均速度（吞吐量）例如 `MB/s = downloaded_bytes / time_seconds / (1024*1024)`。

需要注意的是，网络环境存在带宽和抖动，同一 URL 的多次下载耗时可能不同，因此实验中必须多次重复（如 `--repeat 3`）并取平均；同时每次下载前应删除已存在的输出文件，避免缓存或追加写入影响结果，并在结束时正确关闭流与连接（可调用 `disconnect()`），保证资源释放完整。

以下是一份从指定URL中下载资源的示例代码：

```java
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class SimpleDownload {
    public static void main(String[] args) throws Exception {
        // args[0]：要下载的资源 URL
        // args[1]：保存到本地的文件路径
        URL url = new URL(args[0]);

        // url.openStream() 会返回一个输入流：从网络中“读取”数据
        // FileOutputStream 用于把数据“写入”到本地文件
        try (InputStream in = url.openStream();
             FileOutputStream out = new FileOutputStream(args[1])) {

            // 用一个固定大小的缓冲区，每次读一块数据，避免逐字节读写过慢
            byte[] buf = new byte[8192];

            int n; // 本次实际读取到的字节数（-1 表示读完）
            while ((n = in.read(buf)) != -1) {
                // 把 buf 中前 n 个字节写入文件
                out.write(buf, 0, n);
            }
        } // try-with-resources：自动关闭输入/输出流，释放资源
    }
}
```

## 实验内容

1. 给定目录名, 找出该目录下的所有文件和子目录, 并递归的列出所有子目录的内容. 按照以下方式输出

```
parent_dir1:
           |- a.txt
           |- b.txt
           |- sub_dir1:
                      |- e.txt
                      |- f.txt
           |- c.txt
           |- d.txt
parent_dir2:
           | g.txt
...
```


2. 请**通过编写程序**, 比较带缓冲的流和不带缓冲的流在读写性能上的差距. 请给出实验程序源码, 并说明实验比较步骤和实验结果. 

3. 给定一个**大文本文件**路径 [`input.txt`](https://www.modelscope.cn/models/Qwen/Qwen3-0.6B/resolve/master/merges.txt)，请编写程序统计该文件的 **总字节数** 与 **总行数**（以遇到 `\n` 作为一行结束）。程序要求支持命令行参数：

   - `-i input.txt`：输入文件（必选）
   - `--repeat k`：重复运行 k 次取平均耗时（可选，默认 5）

   并按如下形式输出统计结果与耗时对比（其中 `NO_BUFFER` 表示使用 `FileInputStream` 直接读取；`BUFFERED` 表示使用 `BufferedInputStream` 读取）：

   ```zsh
   file: input.txt
   bytes: 104857600
   lines: 1234567
   
   repeat=5 avg:
   [NO_BUFFER]  avg=800 ms
   [BUFFERED ]  avg=125 ms
   ```

3. 请**通过编写程序**实现一个简单的HTTP 文件下载器：给定一个 [URL](https://www.modelscope.cn/models/Qwen/Qwen3-0.6B/resolve/master/model.safetensors)，将内容下载并保存为本地文件。然后比较 **不带缓冲** 与 **带缓冲** 两种实现的下载耗时差异。请给出实验程序源码，并说明实验比较步骤和实验结果。

   程序要求支持命令行参数：

   - `--url <http_url>`：下载链接（必选，HTTP/HTTPS）
   - `-o <out_file>`：输出文件路径（必选）
   - `--repeat k`：重复下载 k 次取平均耗时（可选，默认 3）

   输出格式参考如下：

   ```zsh
   url: https://...
   out: bigfile.bin
   downloaded_bytes: 104857600
   
   repeat=3 avg:
   [NO_BUFFER] time=25.3 s  speed=3.95 MB/s
   [BUFFERED ] time=8.1 s   speed=12.3 MB/s
   ```

   网络 I/O 额外说明：

   - 网络带宽与抖动会影响结果，必须使用 `--repeat` 多次取平均；两种方案应下载同一个 URL。
   - 为保证公平，每次下载前应删除已有输出文件，避免“文件已存在导致跳过/追加”等干扰。
   - 下载结束后必须正确关闭流（输入流、输出流），并关闭连接（`HttpURLConnection.disconnect()`）。

   

   
