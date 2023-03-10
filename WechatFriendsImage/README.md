# 概述
主要基于python的wxpy库统计微信好友性别、省份、个性签名数据，基于pyecharts库作图表呈现。

# 相关知识
## wxpy库
wxpy在itchat的基础上，通过大量接口优化提升了模块的易用性，并进行了丰富的功能扩展，主要用来实现各种微信个人号的自动化操作。例如：

- 控制路由器、智能家居等具有开放接口的玩意儿
- 运行脚本时自动把日志发送到你的微信
- 加群主为好友，自动拉进群中
- 跨号或跨群转发消息
- 自动陪人聊天
- 逗人玩
- ......

## pyecharts库
pyecharts 是一个用于生成 Echarts 图表的类库。Echarts 是百度开源的一个数据可视化 JS 库。用 Echarts 生成的图可视化效果非常棒，pyecharts 是为了与 Python 进行对接，方便在 Python 中直接使用数据生成图。

## jieba库
"结巴"是python中文分词组件，支持三种分词模式：

- 精确模式，试图将句子最精确地切开，适合文本分析；
- 全模式，把句子中所有的可以成词的词语都扫描出来, 速度非常快，但是不能解决歧义；
- 搜索引擎模式，在精确模式的基础上，对长词再次切分，提高召回率，适合用于搜索引擎分词。

## 停用词表
综合了"百度停用词表"，"哈工大停用词表"，"四川大学机器学习实验室停用词表"等若干停用词表，取交集并去除了不需要的标点符号和英文单词。

# 代码思想
### 第一阶段
创建bot对象，获取全部微信好友
### 第二阶段
遍历好友信息，计算性别分布、省份分布、个性签名切词生成词云。其中词云处稍微复杂，需要过滤空格、html标签、emoj表情以及停用词。
### 第三阶段
分别获取性别饼状图、省份地图、词云三者的图表对象。词云图表在处理前对数据进行一次归一化。
### 第四阶段
创建Page类，将图表对象add进去，最后渲染页面

# 参考资料
1. [wxpy: 用 Python 玩微信](https://wxpy.readthedocs.io/zh/latest/index.html "wxpy: 用 Python 玩微信")
2. [pyecharts 文档](http://pyecharts.org/#/ "pyecharts 文档")
3. [jieba](https://github.com/fxsjy/jieba "jieba")
4. [停用词表](https://github.com/dongxiexidian/Chinese "停用词表")
