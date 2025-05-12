# 在Mac OS下 使用nginx 部署教程中的前端项目



## 如果没有安装nginx, 那就安装

### 安装nginx

```bash
brew install nginx 
```

### 安装信息

```bash
 % brew info nginx
==> nginx: stable 1.27.5 (bottled), HEAD
HTTP(S) server and reverse proxy, and IMAP/POP3 proxy server
https://nginx.org/
Installed
/opt/homebrew/Cellar/nginx/1.27.5 (27 files, 2.5MB) * # 这里是安装目录
  Poured from bottle using the formulae.brew.sh API on 2025-05-12 at 22:25:17
From: https://github.com/Homebrew/homebrew-core/blob/HEAD/Formula/n/nginx.rb
License: BSD-2-Clause
==> Dependencies
Required: openssl@3 ✔, pcre2 ✔
==> Options
--HEAD
	Install HEAD version
==> Caveats
Docroot is: /opt/homebrew/var/www 

The default port has been set in /opt/homebrew/etc/nginx/nginx.conf to 8080 so that
nginx can run without sudo. # 这里的目录地址是 配置文件目录 也就是nginx.conf 目录

nginx will load all files in /opt/homebrew/etc/nginx/servers/.

To start nginx now and restart at login:
  brew services start nginx
Or, if you don't want/need a background service you can just run:
  /opt/homebrew/opt/nginx/bin/nginx -g daemon\ off\;
==> Analytics
install: 16,054 (30 days), 39,873 (90 days), 165,649 (365 days)
install-on-request: 16,032 (30 days), 39,778 (90 days), 165,209 (365 days)
build-error: 13 (30 days)

```

### 在终端打开`/opt/homebrew/Cellar/nginx`

```
open /opt/homebrew/Cellar/nginx
```

<img src="/Users/wheat/Desktop/AI-JavaWeb-Dev/web-ai-project02/img/CleanShot 2025-05-12 at 23.30.00@2x.png" alt="CleanShot 2025-05-12 at 23.30.00@2x" style="zoom:50%;" />

### 然后打开上图html文件夹, 然后把下载好的nginx-1.22.0-web.zip 解压出来.把下图红框里的文件夹复制一下, 粘贴进去

<img src="/Users/wheat/Desktop/AI-JavaWeb-Dev/web-ai-project02/img/CleanShot 2025-05-12 at 23.32.51@2x.png" alt="CleanShot 2025-05-12 at 23.32.51@2x" style="zoom:50%;" /><img src="/Users/wheat/Desktop/AI-JavaWeb-Dev/web-ai-project02/img/CleanShot 2025-05-12 at 23.35.58@2x.png" alt="CleanShot 2025-05-12 at 23.35.58@2x" style="zoom:50%;" />



### 紧接着修改配置, 打开配置文件夹, 编辑nginx.conf

```
open /opt/homebrew/etc/nginx/
```

<img src="/Users/wheat/Desktop/AI-JavaWeb-Dev/web-ai-project02/img/CleanShot 2025-05-12 at 23.39.18@2x.png" alt="CleanShot 2025-05-12 at 23.39.18@2x" style="zoom:50%;" />

然后编辑看下图 大概在35行的位置,只要看到server 这里就行了.

<img src="/Users/wheat/Desktop/AI-JavaWeb-Dev/web-ai-project02/img/CleanShot 2025-05-12 at 23.40.39@2x.png" alt="CleanShot 2025-05-12 at 23.40.39@2x" style="zoom: 33%;" />



#### 不多说了,直接复制我给出代码, 替换一下即可, 上图是我修改好的. 你修改的时候,直接 复制替换掉框住的即可..

```yml
 server {
        listen       90;
        server_name  localhost;
        client_max_body_size 10m;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html/html;
            index  index.html index.htm;
            try_files $uri $uri/ /index.html;
        }

        location ^~ /api/ {
            rewrite ^/api/(.*)$ /$1 break;
            proxy_pass http://localhost:8080;
        }
```



#### 然后在终端 输入一下命令

```
# 启动服务
sudo nginx

# 如果已经启动了就重新加载一下配置文件
sudo nginx -s reload

# 不想用了就停止服务
sudo nginx -s stop

# 退出服务
sudo nginx -s quit
```



###  chatgpt提供的nginx命令.

当然，以下是常用的 Nginx 命令：

| **命令**                                           | **说明**                                 |
| -------------------------------------------------- | ---------------------------------------- |
| sudo nginx                                         | 启动 Nginx 服务                          |
| sudo nginx -s reload                               | 重新加载 Nginx 配置文件                  |
| sudo nginx -t                                      | 测试 Nginx 配置文件是否正确              |
| sudo nginx -s stop                                 | 停止 Nginx 服务                          |
| sudo nginx -s quit                                 | 退出 Nginx 服务（优雅关闭）              |
| brew services start nginx                          | 启动 Nginx（使用 Homebrew 服务）         |
| brew services stop nginx                           | 停止 Nginx（使用 Homebrew 服务）         |
| brew services restart nginx                        | 重启 Nginx（使用 Homebrew 服务）         |
| brew services list                                 | 查看当前所有通过 Homebrew 管理的服务     |
| sudo tail -f /var/log/nginx/error.log              | 查看 Nginx 错误日志（动态输出）          |
| sudo tail -f /opt/homebrew/var/log/nginx/error.log | 查看 macOS 上 Nginx 错误日志（动态输出） |
| `ps aux                                            | grep nginx`                              |
| sudo kill -QUIT <pid>                              | 优雅停止指定的 Nginx 进程                |

这些是一些常用的 Nginx 管理命令，希望对你有帮助！