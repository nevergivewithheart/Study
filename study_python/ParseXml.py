# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

from xml.dom.minidom import parse
import string

# 读取文件
dom = parse('./temp.xml')
# 获取文档元素对象
data = dom.documentElement

# 获取元素组信息
element = data.getElementsByTagName('Element')
handle = element[0].getAttribute('handle')
version = element[0].getAttribute('version')
kind = element[0].getAttribute('type')
