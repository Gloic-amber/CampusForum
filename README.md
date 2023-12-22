# CampusForum 部署步骤
* 见configuration文件夹
* 需要部署的基础软件有：mysql，redis，rabbitmq，minio，elasticsearch（8以下的版本），kibana，nacos
* 前端：进入到FrontEnd文件夹中，运行``npm install --registry=https://registry.npmmirror.com``，再运行``npm run serve``启动项目