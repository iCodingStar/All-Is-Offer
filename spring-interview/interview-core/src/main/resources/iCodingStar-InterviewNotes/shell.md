## Shell 笔记

### shell命令的执行流程

#### shell执行原理
* shell是系统的用户界面，提供了用户与内核进行交互的一种接口。它接收用户的输入命令，并把它送入到内核去执行。
    * shell分析命令及参数
    * fork拷贝最近的pcb相关资源，为命令执行做准备(系统调用)
    * exec在fork得到的子进程中执行命令
    * 在执行命令的过程中，我们无法输入命令的，这是因为父进程在fork执行shell命令的同同时，会执行wait等待子进程执行结束。

#### 声明解释器
* 脚本文件起始行大多以`#!`开始，这是因为脚本文件并非二进制文件，需要解释器解释执行，这样写就是为了声明执行脚本的解释器。
   * python脚本解释器声明： `#!/usr/bin/env python`
   * shell脚本解释器声明： `#!/bin/bash`
   
   这里利用命令 `env` 得到可执行程序路径，Linux内核通过`load_script()`函数解析脚本文件，`#!`就是在这个函数中解析的，解析到`#!`后，内核会获得其后面的可执行程序执行路径，
   再传递给 `search_binary_handler()`重新解析。这样，最终找到了真正的可执行二进制文件执行相应的脚本。
* 对于解释器而言 `#`开头意味着该行是注释，在执行的时候，直接忽略掉了。

#### bash执行命令的过程
* bash进行文本解析(文本以分号，回车等作为分隔符)，进行分段；
* bash对段进行解析，主要解析的字符有管道符 `|`以及`&&`、`||`这样可以起到连接作用的字符，解析完毕即可获取到一个个要执行的命令；
* bash拿到命令后，继续解析，区分要执行的命令以及参数，绝大多数解析完的字符串，bash都是在fork()之后交给exec()执行，然后wait()其执行完毕；

#### 名字冲突是命令的执行顺序
* 别名(alias):给现有命令添加别名 `alias ls='ls -l'`
* 关键字(key word):bash提供的语法
* 函数(function):用function关键字定义一个函数
* 内建命令(built in):内建命令是bash自身实现的命令，如`cd,pwd`等
* 哈希索引(hash)：第一次找到命令的路径之后，根据路径名与路径建立一个hash索引，以便于以后用到时，快速找到命令的位置；
* 外部命令(command)：外建命令基本都放在 `$PATH`路径下，执行时都是创建子进程(fork、exec、wait)

通过 `type` 可以查看命令的类型属性

```shell
star@codingstar:~$ type passwd
passwd is /usr/bin/passwd
star@codingstar:~$ type is
bash: type: is: not found
star@codingstar:~$ type if
if is a shell keyword
star@codingstar:~$ type fi
fi is a shell keyword
star@codingstar:~$ type egrep
egrep is aliased to `egrep --color=auto'
star@codingstar:~$ type grep
grep is aliased to `grep --color=auto'
star@codingstar:~$ type shopt
shopt is a shell builtin
```
