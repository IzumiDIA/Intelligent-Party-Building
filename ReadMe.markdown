# 1. 简介

**中北党建平台**

## 1.1 项目开发目的

中北党建平台旨在：

1. 为学生提供便捷的学生综合素质测评明细表信息填写、分值计算、信息汇总、校验功能。
2. 为学生提供便捷的入党申请材料的填写，提交功能。
3. 为辅导员老师提供方便的入党材料审核，信息汇总的功能。
4. 将部分入党材料的审核流程自动化以避免人工处理。
5. 作为信息工程学院的党建线上系统，由管理员将信工院学生党员、入党积极分子等党建信息材料录入系统，达到审核流程自动化、快速化、高效化。
6. 由于本团队成员为党建工作部负责人，对党建信息关键之处较为熟悉，该系统可与信息工程学院学生党建工作部高度配合，提高材料部审核效率。同时，该系统也可提高信工院整体党建材料情况，也便于存储毕业生党员材料，达到入党材料的关键时间节点不出错，例如“入党申请书时间”、以避免多次人工核对，确保信工院党建信息准确无误。

## 1.2 项目开发基本依赖

1. Java GraalVM 21 (以及native-image执行构建所需的依赖)
2. SpringBoot 3.1.+
3. Apache Maven Daemon 4+
4. MySQL 8.0.+
5. spring-jdbc
6. com.alibaba:easyexcel
7. com.github.hazendaz.maven:htmlcompressor-maven-plugin

## 1.3 项目架构

**B/S 单机应用架构**。此架构特点为结构简单，构建、部署成本低。

## 1.4 项目开发工具

1. IntelliJ IDEA
2. WebStorm
3. Navicat Premium
4. Apifox
5. Git

## 1.5 项目设计

### 1.5.1 中北党建平台学生使用流程图

![中北党建平台学生使用流程图](/design/assets/中北党建平台学生使用流程.svg)

### 1.5.2 中北党建平台入党流程泳道图

![中北党建平台入党流程泳道图](/design/assets/中北党建平台入党流程泳道图.svg)

### 1.5.3 中北党建平台管理员使用流程

![中北党建平台管理员使用流程](/design/assets/中北党建平台管理员使用流程.svg)

# 2. 构建

## 2.1 构建方式

### 2.1.1 Fat JAR 包构建

1. 在项目根目录路径下，执行构建指令：
	```shell
	mvnd -DskipTests package
	```
2. 如果成功，则最后在 main 模块的 target 文件夹下，生成有.jar包。

#### 2.1.2 Windows平台下的AOT构建

1. 确保有安装好 Microsoft Visual Studio 2022 以及相应的C++构建环境。
2. 在项目根目录路径下，打开 ***x64 Native Tools Command Prompt for VS 2022***，在该命令行下执行指令：
	```shell
	mvnd -Pnative -DskipTests package
	```
	- 切**勿**使用**IntelliJ IDEA内置的终端**功能。
    - 使用原始的Command来执行该指令。
3. 如果成功，则最后在 main 模块的 target 文件夹下，生成有执行文件。
