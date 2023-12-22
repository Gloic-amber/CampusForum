/*
 Navicat Premium Data Transfer

 Source Server         : ubuntu-docker-cf-mysql
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : 192.168.111.128:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 22/12/2023 10:30:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `author_id` int UNSIGNED NOT NULL COMMENT '作者id',
  `title` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `description` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '描述',
  `school_code` int UNSIGNED NULL DEFAULT NULL COMMENT '院校代码',
  `cover_image` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL COMMENT '封面图',
  `release_time` datetime NULL DEFAULT NULL COMMENT '发表时间',
  `write_type` tinyint UNSIGNED NOT NULL DEFAULT 1 COMMENT '博客创作类型：1. 原创; 2. 转载',
  `status` tinyint UNSIGNED NOT NULL COMMENT '发表状态（1表示已发表、2表示未发表、3为仅自己可见、4为回收站、5为审核中）',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已经删除，0未删除，1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `author_id`(`author_id` ASC) USING BTREE,
  INDEX `school_code`(`school_code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (12, 4, '这是一篇测试文章4444444444444', '啊防守打法', NULL, 'http://127.0.0.1/resource/image/6999dfd768dc1bb59ae217ebe69253b3', '2023-12-16 21:18:12', 1, 1, '2023-12-16 21:18:12', '2023-12-18 10:43:32', 0);
INSERT INTO `blog` VALUES (13, 4, '启动微服务时feign报错', '高软大作业中遇到的问题1', NULL, 'http://127.0.0.1/resource/image/9d155acc2ef03c348dbac9008661aa44', '2023-12-18 10:41:53', 1, 1, '2023-12-18 10:41:53', '2023-12-18 10:41:52', 0);
INSERT INTO `blog` VALUES (14, 1, '高软大作业中遇到的问题2', '8.x版本的elasticsearch在docker中的部署问题', NULL, 'http://127.0.0.1/resource/image/5ea7dd07219604abeaf91baaec4f7e9f', '2023-12-18 14:45:43', 1, 1, '2023-12-18 14:45:43', '2023-12-20 11:48:45', 0);
INSERT INTO `blog` VALUES (15, 5, '高软大作业中遇到的问题2', 'mapper中使用了MyBatis的注解方式来定义数据库操作的问题', NULL, 'http://127.0.0.1/resource/image/95c000f442567fb8ec0409a68b442b44', '2023-12-18 14:51:35', 1, 1, '2023-12-18 14:51:35', '2023-12-18 14:51:34', 0);
INSERT INTO `blog` VALUES (16, 5, '关于IDEA中Settings设置中target bytecode version经常自动变换的问题', '在idea中的项目，将java版本从jdk17变为jdk8的时候，经常会报错：``java: 无效的目标发行版: 17``\r\n\r\n这个错误是因为IntelliJ IDEA项目的JDK版本和本地环境配置的JDK版本不一致。你可以通过以下步骤来解决这个问题：', NULL, 'http://127.0.0.1/resource/image/0ac0dc277839940fca4ff9044b9b9a98', '2023-12-18 14:53:06', 1, 1, '2023-12-18 14:53:06', '2023-12-18 14:53:05', 0);
INSERT INTO `blog` VALUES (17, 1, '虚拟机强制关机后无法联网的问题', '打开终端：\r\n\r\n1、先关掉NetworkManager：\r\n\r\n```text\r\nsudo service NetworkManager stop\r\n```\r\n\r\n2、用gedit打开NetworkManager.state：', NULL, 'http://127.0.0.1/resource/image/d015029160590c5d2af60c8394bad5e6', '2023-12-18 14:54:27', 1, 1, '2023-12-18 14:54:27', '2023-12-20 11:23:36', 0);
INSERT INTO `blog` VALUES (18, 1, 'Docker中搭建redis集群的方法', '在自己使用docker搭建redis集群的时候，发现了很多问题。究其原因，其实是因为自己不了解docker的原理导致。现在按照顺序介绍搭建集群的方法，同时列出自己遇到的问题。', NULL, 'http://127.0.0.1/resource/image/41c5de2dd1a36231836e70cc83cf3049', '2023-12-19 10:06:43', 1, 1, '2023-12-19 10:06:43', '2023-12-19 10:06:43', 0);
INSERT INTO `blog` VALUES (19, 13, '主机无法ping通虚拟机', 'sadfadsf', NULL, 'http://127.0.0.1/resource/image/49131c809253e4af133fe458c3decb35', '2023-12-20 12:25:57', 1, 4, '2023-12-20 12:25:57', '2023-12-20 12:26:05', 0);
INSERT INTO `blog` VALUES (20, 1, '这是一篇测试文章55555555', '这是一篇测试文章55555555555', NULL, 'http://127.0.0.1/resource/image/0a05df5fc9271900393aedd98fd3b84c', '2023-12-20 15:10:59', 1, 1, '2023-12-20 15:10:59', '2023-12-20 15:10:58', 0);

-- ----------------------------
-- Table structure for blog_content
-- ----------------------------
DROP TABLE IF EXISTS `blog_content`;
CREATE TABLE `blog_content`  (
  `blog_id` int UNSIGNED NOT NULL COMMENT '博客id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '博客内容',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0未删除，1已删除',
  PRIMARY KEY (`blog_id`) USING BTREE,
  UNIQUE INDEX `blog_id`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_content
-- ----------------------------
INSERT INTO `blog_content` VALUES (12, '这是一篇测试文章4444444444444![111.png](http://127.0.0.1/resource/image/6999dfd768dc1bb59ae217ebe69253b3)', '2023-12-16 21:18:08', 0);
INSERT INTO `blog_content` VALUES (13, ' java.lang.IllegalStateException: RequestParam.value() was empty on parameter 0\r\n\r\n​	一种方法是在服务的所有的**@RequestParam注解**上添加上value字段，即\r\n\r\n```\r\nselectUserOnetById(@RequestParam String userId);\r\n \r\n// 加上value字段，改成\r\n \r\nselectUserOnetById(@RequestParam(\"userId\") String userId);\r\n```\r\n\r\n​	另一种方法是升级maven版本，因为根源就在于maven的版本问题\r\n\r\n​	升级Maven的版本到3.8.1，替换Idea中Maven的版本。\r\n​	或者升级maven-compiler-plugin插件，我们之前用的是3.6.0版本，升级为3.8.1就可以解决这个问题。', '2023-12-18 10:41:52', 0);
INSERT INTO `blog_content` VALUES (14, '## 8.x版本的elasticsearch在docker中无法挂载配置文件elasticsearch.yml，需要使用docker cp命令从外部复制配置文件进去。', '2023-12-18 14:45:41', 0);
INSERT INTO `blog_content` VALUES (15, '# mapper中使用了MyBatis的注解方式来定义数据库操作的问题\r\n在mapper中，可以使用如下的注解方式定义数据库操作，而不一定要把语句写在xml文件中，但是这样会导致报错，所以还是需要加上@param注解\r\n```\r\n@Update(\"update `user`.`user_safety` set `password` = #{password} where `user_id` = #{id};\")\r\nint updatePasswordById(Integer id, String password);\r\n//修改后\r\n@Update(\"update `user`.`user_safety` set `password` = #{password} where `user_id` = #{id};\")\r\nint updatePasswordById(@Param(\"id\") Integer id, @Param(\"password\") String password);', '2023-12-18 14:51:34', 0);
INSERT INTO `blog_content` VALUES (16, '在idea中的项目，将java版本从jdk17变为jdk8的时候，经常会报错：``java: 无效的目标发行版: 17``\r\n\r\n这个错误是因为IntelliJ IDEA项目的JDK版本和本地环境配置的JDK版本不一致。你可以通过以下步骤来解决这个问题：\r\n\r\n1. 打开IntelliJ IDEA，点击`Settings`。\r\n2. 选择`Build, Execution, Deployment` --> `Complier` --> `Java Complier`。\r\n3. 在`Java Complier`配置下的`Project bytecode version: 17`改为与项目使用的JDK版本一样。\r\n\r\n后来我发现我的程序有时还是会报这种错误，去到设置里看，发现JDK的版本又被修改了。所以这是种治标不治本的办法。\r\n\r\nIDEA有时会自动修改你的target bytecode version属性，所以为了不用频繁地去修改target bytecode version的值，我们可以在pom.xml文件中去配置相应的东西。\r\n\r\n```xml\r\n<plugin>\r\n    <groupId>org.apache.maven.plugins</groupId>\r\n    <artifactId>maven-compiler-plugin</artifactId>\r\n    <configuration>\r\n      <source>1.8</source>\r\n      <target>1.8</target>\r\n    </configuration>\r\n </plugin>\r\n```\r\n\r\n', '2023-12-18 14:53:05', 0);
INSERT INTO `blog_content` VALUES (17, '打开终端：\r\n\r\n1、先关掉NetworkManager：\r\n\r\n```text\r\nsudo service NetworkManager stop\r\n```\r\n\r\n2、用gedit打开NetworkManager.state：\r\n\r\n```text\r\nsudo gedit /var/lib/NetworkManager/NetworkManager.state\r\n```\r\n\r\n3、改成下面这样，再保存，关闭。\r\n\r\n```text\r\n[main]\r\nNetworkingEnabled=true\r\nWirelessEnabled=true\r\nWWANEnabled=true\r\n```\r\n\r\n4、重启NetworkManager：\r\n\r\n```text\r\nsudo service NetworkManager restart\r\n```\r\n\r\n5、完成，顺利连网！\r\n\r\n注意：不同版本的Ubuntu略有差异，有其他博主在Ubuntu18上使用sudo service network-manager start是可行的，但是在Ubuntu22上，network-manager要替换成NetworkManager，否则会提示Failed to start network-manager.service: Unit network-manager.service not found.', '2023-12-18 14:54:25', 0);
INSERT INTO `blog_content` VALUES (18, '在自己使用docker搭建redis集群的时候，发现了很多问题。究其原因，其实是因为自己不了解docker的原理导致。现在按照顺序介绍搭建集群的方法，同时列出自己遇到的问题。\r\n\r\n## 配置redis.conf文件\r\n\r\ndocker中要创建redis容器，其配置文件的设置其实有两种，一种是在外部写好配置文件，挂载到容器中。另一种是在容器内部对配置文件进行修改。\r\n\r\n我这里使用了外部挂载的方法，因为要创建多个redis节点，需要copy一下配置文件。此时内部修改就比较麻烦。\r\n\r\n配置文件如下，其中注释掉的配置是让我遇到问题的原因。由于配置文件是挂载到容器内部的，所以``logfile,pidfile和dir``是不需要配置的，如果像这样配置了，在容器中就会找不到对应的文件，导致容器启动失败，使用``docker ps -a``就会发现容器的状态为``exit（1）``。直到我使用了``docker logs 容器id``查看了日志后才发现问题。还有在docker容器中是不需要让redis后台运行的（即令``daemonize yes``），如果让redis后台运行，就会让容器执行完``redis-server 配置文件``后，直接结束容器的运行。所以要让redis服务器在前台运行。否则就可以看到容器的状态为``exit（0）``。\r\n\r\n```\r\n############ configration\r\nbind 0.0.0.0\r\n#daemonize yes\r\nprotected-mode no\r\nport 6381\r\n# logfile \"/myredis/cluster/cluster6381.log\"\r\n# pidfile /myredis/cluster6381.pid\r\n# dir /myredis/cluster\r\ndbfilename dump6381.rdb\r\nappendonly yes\r\nappendfilename \"appendonly6381.aof\"\r\nrequirepass 111111\r\nmasterauth 111111\r\n \r\ncluster-enabled yes\r\ncluster-config-file nodes-6381.conf\r\ncluster-node-timeout 5000\r\n#############\r\n```\r\n\r\n## 使用docker run命令启动容器\r\n\r\n```\r\ndocker run \\\r\n--net mynetwork \\  													#使用自己的网络\r\n-p 6381:6379 \\  													#端口映射 容器端口->宿主机端口\r\n--ip 172.60.0.2 \\  													#指定ip地址\r\n-v /myredis/cluster/redisCluster6381.conf:/etc/redis/redis.conf \\  	#挂载配置文件\r\n-v /myredis/cluster/data:/data \\  									#挂载数据文件夹\r\n--name redis-6381 \\  												#容器名称\r\n-d redis \\   														#-d为后台运行，redis为镜像名称\r\nredis-server /etc/redis/redis.conf   								#redis服务器启动的命令\r\n```\r\n\r\ndocker run命令如上，我这里使用的是自己的桥接网络，让6个redis服务器的ip从172.60.0.2到172.60.0.7，端口映射从容器的6381-6386映射到了宿主机的6379端口。其实这里是有问题的，因为这样映射，只能从宿主机对集群进行访问了，而无法从外部访问集群（因为都映射到了同一端口6379）。正确的方法应该是都从容器的6379端口映射到宿主机的不同端口。（当然注意修改配置文件的端口号）。由于自己的错误映射，只能在宿主机中使用``redis-cli -a 111111 -h 172.60.0.2 -p 6381 -c``这样的命令来访问集群。\r\n\r\n如果使用主机网络，即``--net host``，就不需要设置ip地址，统一使用宿主机的ip，例如我的虚拟机ip地址为192.168.111.128，当然也要注意需要映射到不同的端口。\r\n\r\n## 创建集群\r\n\r\n进行以上配置后，使用如下命令就创建了redis集群。\r\n\r\n```\r\nredis-cli -a 111111 --cluster create --cluster-replicas 1 172.60.0.2:6381 172.60.0.3:6382 172.60.0.4:6383 172.60.0.5:6384 172.60.0.6:6385 172.60.0.7:6386\r\n```\r\n\r\n使用如下命令即可连接上集群。\r\n\r\n```\r\nredis-cli -a 111111 -h 172.60.0.2 -p 6381 -c\r\n```\r\n\r\n', '2023-12-19 10:06:43', 0);
INSERT INTO `blog_content` VALUES (19, '因为之前创建的虚拟机的vm8的ipv4的网段不同，解决方法看[解决vmware中NAT模式下主机ping不通虚拟机问题_wmware nat无法ping本地的-CSDN博客](https://blog.csdn.net/sa726663676/article/details/121311612)![QQ图片20231218144018.jpg](http://127.0.0.1/resource/image/04ebe2929112e502da70d3d435c04a07)', '2023-12-20 12:25:56', 0);
INSERT INTO `blog_content` VALUES (20, '# 这是一篇测试文章\r\n# 55555555', '2023-12-20 15:10:58', 0);

-- ----------------------------
-- Table structure for blog_content_html
-- ----------------------------
DROP TABLE IF EXISTS `blog_content_html`;
CREATE TABLE `blog_content_html`  (
  `blog_id` int UNSIGNED NOT NULL COMMENT '博客id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '博客内容（html）',
  `modified_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`blog_id`) USING BTREE,
  UNIQUE INDEX `blog_id`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_content_html
-- ----------------------------
INSERT INTO `blog_content_html` VALUES (12, '<p>这是一篇测试文章4444444444444<img src=\"http://127.0.0.1/resource/image/6999dfd768dc1bb59ae217ebe69253b3\" alt=\"111.png\" /></p>\r\n', '2023-12-16 21:18:08', 0);
INSERT INTO `blog_content_html` VALUES (13, '<p>java.lang.IllegalStateException: RequestParam.value() was empty on parameter 0</p>\r\n<p>​	一种方法是在服务的所有的**@RequestParam注解**上添加上value字段，即</p>\r\n<pre><code class=\"lang-\">selectUserOnetById(@RequestParam String userId);\r\n \r\n// 加上value字段，改成\r\n \r\nselectUserOnetById(@RequestParam(&quot;userId&quot;) String userId);\r\n</code></pre>\r\n<p>​	另一种方法是升级maven版本，因为根源就在于maven的版本问题</p>\r\n<p>​	升级Maven的版本到3.8.1，替换Idea中Maven的版本。<br />\r\n​	或者升级maven-compiler-plugin插件，我们之前用的是3.6.0版本，升级为3.8.1就可以解决这个问题。</p>\r\n', '2023-12-18 10:41:52', 0);
INSERT INTO `blog_content_html` VALUES (14, '<h2><a id=\"8xelasticsearchdockerelasticsearchymldocker_cp_0\"></a>8.x版本的elasticsearch在docker中无法挂载配置文件elasticsearch.yml，需要使用docker cp命令从外部复制配置文件进去。</h2>\r\n', '2023-12-18 14:45:42', 0);
INSERT INTO `blog_content_html` VALUES (15, '<h1><a id=\"mapperMyBatis_0\"></a>mapper中使用了MyBatis的注解方式来定义数据库操作的问题</h1>\r\n<p>在mapper中，可以使用如下的注解方式定义数据库操作，而不一定要把语句写在xml文件中，但是这样会导致报错，所以还是需要加上@param注解</p>\r\n<pre><code class=\"lang-\">@Update(&quot;update `user`.`user_safety` set `password` = #{password} where `user_id` = #{id};&quot;)\r\nint updatePasswordById(Integer id, String password);\r\n//修改后\r\n@Update(&quot;update `user`.`user_safety` set `password` = #{password} where `user_id` = #{id};&quot;)\r\nint updatePasswordById(@Param(&quot;id&quot;) Integer id, @Param(&quot;password&quot;) String password);</code></pre>\r\n', '2023-12-18 14:51:34', 0);
INSERT INTO `blog_content_html` VALUES (16, '<p>在idea中的项目，将java版本从jdk17变为jdk8的时候，经常会报错：<code>java: 无效的目标发行版: 17</code></p>\r\n<p>这个错误是因为IntelliJ IDEA项目的JDK版本和本地环境配置的JDK版本不一致。你可以通过以下步骤来解决这个问题：</p>\r\n<ol>\r\n<li>打开IntelliJ IDEA，点击<code>Settings</code>。</li>\r\n<li>选择<code>Build, Execution, Deployment</code> --&gt; <code>Complier</code> --&gt; <code>Java Complier</code>。</li>\r\n<li>在<code>Java Complier</code>配置下的<code>Project bytecode version: 17</code>改为与项目使用的JDK版本一样。</li>\r\n</ol>\r\n<p>后来我发现我的程序有时还是会报这种错误，去到设置里看，发现JDK的版本又被修改了。所以这是种治标不治本的办法。</p>\r\n<p>IDEA有时会自动修改你的target bytecode version属性，所以为了不用频繁地去修改target bytecode version的值，我们可以在pom.xml文件中去配置相应的东西。</p>\r\n<pre><div class=\"hljs\"><code class=\"lang-xml\"><span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">plugin</span>&gt;</span>\r\n    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">groupId</span>&gt;</span>org.apache.maven.plugins<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">groupId</span>&gt;</span>\r\n    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">artifactId</span>&gt;</span>maven-compiler-plugin<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">artifactId</span>&gt;</span>\r\n    <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">configuration</span>&gt;</span>\r\n      <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">source</span>&gt;</span>1.8<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">source</span>&gt;</span>\r\n      <span class=\"hljs-tag\">&lt;<span class=\"hljs-name\">target</span>&gt;</span>1.8<span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">target</span>&gt;</span>\r\n    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">configuration</span>&gt;</span>\r\n <span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">plugin</span>&gt;</span>\r\n</code></div></pre>\r\n', '2023-12-18 14:53:05', 0);
INSERT INTO `blog_content_html` VALUES (17, '<p>打开终端：</p>\r\n<p>1、先关掉NetworkManager：</p>\r\n<pre><div class=\"hljs\"><code class=\"lang-text\">sudo service NetworkManager stop\r\n</code></div></pre>\r\n<p>2、用gedit打开NetworkManager.state：</p>\r\n<pre><div class=\"hljs\"><code class=\"lang-text\">sudo gedit /var/lib/NetworkManager/NetworkManager.state\r\n</code></div></pre>\r\n<p>3、改成下面这样，再保存，关闭。</p>\r\n<pre><div class=\"hljs\"><code class=\"lang-text\">[main]\r\nNetworkingEnabled=true\r\nWirelessEnabled=true\r\nWWANEnabled=true\r\n</code></div></pre>\r\n<p>4、重启NetworkManager：</p>\r\n<pre><div class=\"hljs\"><code class=\"lang-text\">sudo service NetworkManager restart\r\n</code></div></pre>\r\n<p>5、完成，顺利连网！</p>\r\n<p>注意：不同版本的Ubuntu略有差异，有其他博主在Ubuntu18上使用sudo service network-manager start是可行的，但是在Ubuntu22上，network-manager要替换成NetworkManager，否则会提示Failed to start network-manager.service: Unit network-manager.service not found.</p>\r\n', '2023-12-18 14:54:25', 0);
INSERT INTO `blog_content_html` VALUES (18, '<p>在自己使用docker搭建redis集群的时候，发现了很多问题。究其原因，其实是因为自己不了解docker的原理导致。现在按照顺序介绍搭建集群的方法，同时列出自己遇到的问题。</p>\r\n<h2><a id=\"redisconf_2\"></a>配置redis.conf文件</h2>\r\n<p>docker中要创建redis容器，其配置文件的设置其实有两种，一种是在外部写好配置文件，挂载到容器中。另一种是在容器内部对配置文件进行修改。</p>\r\n<p>我这里使用了外部挂载的方法，因为要创建多个redis节点，需要copy一下配置文件。此时内部修改就比较麻烦。</p>\r\n<p>配置文件如下，其中注释掉的配置是让我遇到问题的原因。由于配置文件是挂载到容器内部的，所以<code>logfile,pidfile和dir</code>是不需要配置的，如果像这样配置了，在容器中就会找不到对应的文件，导致容器启动失败，使用<code>docker ps -a</code>就会发现容器的状态为<code>exit（1）</code>。直到我使用了<code>docker logs 容器id</code>查看了日志后才发现问题。还有在docker容器中是不需要让redis后台运行的（即令<code>daemonize yes</code>），如果让redis后台运行，就会让容器执行完<code>redis-server 配置文件</code>后，直接结束容器的运行。所以要让redis服务器在前台运行。否则就可以看到容器的状态为<code>exit（0）</code>。</p>\r\n<pre><code class=\"lang-\">############ configration\r\nbind 0.0.0.0\r\n#daemonize yes\r\nprotected-mode no\r\nport 6381\r\n# logfile &quot;/myredis/cluster/cluster6381.log&quot;\r\n# pidfile /myredis/cluster6381.pid\r\n# dir /myredis/cluster\r\ndbfilename dump6381.rdb\r\nappendonly yes\r\nappendfilename &quot;appendonly6381.aof&quot;\r\nrequirepass 111111\r\nmasterauth 111111\r\n \r\ncluster-enabled yes\r\ncluster-config-file nodes-6381.conf\r\ncluster-node-timeout 5000\r\n#############\r\n</code></pre>\r\n<h2><a id=\"docker_run_31\"></a>使用docker run命令启动容器</h2>\r\n<pre><code class=\"lang-\">docker run \\\r\n--net mynetwork \\  													#使用自己的网络\r\n-p 6381:6379 \\  													#端口映射 容器端口-&gt;宿主机端口\r\n--ip 172.60.0.2 \\  													#指定ip地址\r\n-v /myredis/cluster/redisCluster6381.conf:/etc/redis/redis.conf \\  	#挂载配置文件\r\n-v /myredis/cluster/data:/data \\  									#挂载数据文件夹\r\n--name redis-6381 \\  												#容器名称\r\n-d redis \\   														#-d为后台运行，redis为镜像名称\r\nredis-server /etc/redis/redis.conf   								#redis服务器启动的命令\r\n</code></pre>\r\n<p>docker run命令如上，我这里使用的是自己的桥接网络，让6个redis服务器的ip从172.60.0.2到172.60.0.7，端口映射从容器的6381-6386映射到了宿主机的6379端口。其实这里是有问题的，因为这样映射，只能从宿主机对集群进行访问了，而无法从外部访问集群（因为都映射到了同一端口6379）。正确的方法应该是都从容器的6379端口映射到宿主机的不同端口。（当然注意修改配置文件的端口号）。由于自己的错误映射，只能在宿主机中使用<code>redis-cli -a 111111 -h 172.60.0.2 -p 6381 -c</code>这样的命令来访问集群。</p>\r\n<p>如果使用主机网络，即<code>--net host</code>，就不需要设置ip地址，统一使用宿主机的ip，例如我的虚拟机ip地址为192.168.111.128，当然也要注意需要映射到不同的端口。</p>\r\n<h2><a id=\"_49\"></a>创建集群</h2>\r\n<p>进行以上配置后，使用如下命令就创建了redis集群。</p>\r\n<pre><code class=\"lang-\">redis-cli -a 111111 --cluster create --cluster-replicas 1 172.60.0.2:6381 172.60.0.3:6382 172.60.0.4:6383 172.60.0.5:6384 172.60.0.6:6385 172.60.0.7:6386\r\n</code></pre>\r\n<p>使用如下命令即可连接上集群。</p>\r\n<pre><code class=\"lang-\">redis-cli -a 111111 -h 172.60.0.2 -p 6381 -c\r\n</code></pre>\r\n', '2023-12-19 10:06:43', 0);
INSERT INTO `blog_content_html` VALUES (19, '<p>因为之前创建的虚拟机的vm8的ipv4的网段不同，解决方法看<a href=\"https://blog.csdn.net/sa726663676/article/details/121311612\" target=\"_blank\">解决vmware中NAT模式下主机ping不通虚拟机问题_wmware nat无法ping本地的-CSDN博客</a><img src=\"http://127.0.0.1/resource/image/04ebe2929112e502da70d3d435c04a07\" alt=\"QQ图片20231218144018.jpg\" /></p>\r\n', '2023-12-20 12:25:56', 0);
INSERT INTO `blog_content_html` VALUES (20, '<h1><a id=\"_0\"></a>这是一篇测试文章</h1>\r\n<h1><a id=\"55555555_1\"></a>55555555</h1>\r\n', '2023-12-20 15:10:58', 0);

-- ----------------------------
-- Table structure for blog_general
-- ----------------------------
DROP TABLE IF EXISTS `blog_general`;
CREATE TABLE `blog_general`  (
  `blog_id` int UNSIGNED NOT NULL COMMENT '博客id',
  `view_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '浏览量',
  `like_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞量',
  `comment_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论量',
  `collection_num` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '收藏量',
  `score` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '评分',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`blog_id`) USING BTREE,
  UNIQUE INDEX `blog_id`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_general
-- ----------------------------
INSERT INTO `blog_general` VALUES (12, 5, 0, 0, 0, 97, 0);
INSERT INTO `blog_general` VALUES (13, 7, 0, 1, 0, 417, 0);
INSERT INTO `blog_general` VALUES (14, 3, 0, 0, 0, 83, 0);
INSERT INTO `blog_general` VALUES (15, 4, 1, 0, 0, 448, 0);
INSERT INTO `blog_general` VALUES (16, 6, 0, 0, 0, 712, 0);
INSERT INTO `blog_general` VALUES (17, 2, 0, 0, 0, 596, 0);
INSERT INTO `blog_general` VALUES (18, 11, 2, 4, 2, 2136, 0);
INSERT INTO `blog_general` VALUES (19, 0, 0, 0, 0, 239, 0);
INSERT INTO `blog_general` VALUES (20, 0, 0, 0, 0, 22, 0);

-- ----------------------------
-- Table structure for blog_set_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_set_tag`;
CREATE TABLE `blog_set_tag`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_id` int UNSIGNED NOT NULL,
  `blog_id` int UNSIGNED NOT NULL,
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_tag_blog`(`tag_id` ASC, `blog_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_set_tag
-- ----------------------------

-- ----------------------------
-- Table structure for collect_blog
-- ----------------------------
DROP TABLE IF EXISTS `collect_blog`;
CREATE TABLE `collect_blog`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `blog_id` int UNSIGNED NOT NULL,
  `user_id` int UNSIGNED NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_blog_collection_user_1`(`user_id` ASC) USING BTREE,
  INDEX `index_blog_collection_blog_1`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_blog
-- ----------------------------
INSERT INTO `collect_blog` VALUES (4, 18, 1, '2023-12-20 09:44:52', 1);
INSERT INTO `collect_blog` VALUES (5, 18, 11, '2023-12-20 12:13:56', 0);
INSERT INTO `collect_blog` VALUES (6, 18, 13, '2023-12-20 12:23:57', 0);

-- ----------------------------
-- Table structure for column
-- ----------------------------
DROP TABLE IF EXISTS `column`;
CREATE TABLE `column`  (
  `id` int NOT NULL COMMENT '专栏id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of column
-- ----------------------------

-- ----------------------------
-- Table structure for like_blog
-- ----------------------------
DROP TABLE IF EXISTS `like_blog`;
CREATE TABLE `like_blog`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞id',
  `blog_id` int UNSIGNED NOT NULL COMMENT '博客id',
  `user_id` int UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_blog_likes_user_1`(`user_id` ASC) USING BTREE,
  INDEX `index_blog_likes_blog_1`(`blog_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of like_blog
-- ----------------------------
INSERT INTO `like_blog` VALUES (5, 13, 4, '2023-12-18 14:35:23', 1);
INSERT INTO `like_blog` VALUES (6, 15, 1, '2023-12-18 21:17:02', 0);
INSERT INTO `like_blog` VALUES (7, 16, 1, '2023-12-20 09:47:38', 1);
INSERT INTO `like_blog` VALUES (8, 18, 11, '2023-12-20 12:13:56', 0);
INSERT INTO `like_blog` VALUES (9, 18, 13, '2023-12-20 12:23:56', 0);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NOT NULL,
  `alias` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_mysql500_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0为未删除，1为已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_mysql500_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- View structure for blog_view
-- ----------------------------
DROP VIEW IF EXISTS `blog_view`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `blog_view` AS select `blog`.`id` AS `id`,`blog`.`author_id` AS `author_id`,`blog`.`title` AS `title`,`blog`.`description` AS `description`,`blog`.`school_code` AS `school_code`,`blog`.`cover_image` AS `cover_image`,`blog`.`create_time` AS `create_time`,`blog`.`release_time` AS `release_time`,`blog`.`modified_time` AS `modified_time`,`blog`.`status` AS `status`,`blog`.`write_type` AS `write_type`,`blog_general`.`view_num` AS `view_num`,`blog_general`.`like_num` AS `like_num`,`blog_general`.`comment_num` AS `comment_num`,`blog_general`.`collection_num` AS `collection_num`,`blog_general`.`score` AS `score` from (`blog` left join `blog_general` on((`blog`.`id` = `blog_general`.`blog_id`))) where (`blog`.`deleted` = 0);

SET FOREIGN_KEY_CHECKS = 1;
