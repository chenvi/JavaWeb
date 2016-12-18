# 主程序
# 作者：chenvdt@aliyun.com
# 时间：2016-12-18 14:09:58
# 说明：本爬虫主要完成了在百度百科对学校信息的抓取

import urllib.parse

from spider import html_downloader
from spider import html_outputer
from spider import html_parser
from spider import parseschool
from spider import url_manager


class SpiderMain(object):
    # 构造函数
    def __init__(self):
        self.urls = url_manager.UrlManager()
        self.downloader = html_downloader.HtmlDownloader()
        self.parser = html_parser.HtmlParser()
        self.outputer = html_outputer.HtmlOutputer()

    # 爬虫函数
    def craw(self, urls):
        count = 1
        self.urls.add_new_urls(urls)
        while self.urls.has_new_url():
            try:
                new_url = self.urls.get_new_url()
                print('spider have crawed %2.2f%% : %s'%(count/len(urls)*100, urllib.parse.unquote(new_url,'utf-8')))
                # print('craw %s'%(urllib.parse.unquote(new_url,'utf-8')))
                # print('craw %s'%(urllib.parse.unquote(new_url,'utf-8')))
                html_cont = self.downloader.download(new_url)
                new_urls, new_data = self.parser.parse(new_url,html_cont)
                self.outputer.collect(new_data)
                count = count + 1

            except:
                print('craw error!')



        self.outputer.output_html()


if __name__ == "__main__":
    # 解析学校名称
    keys = parseschool.ParseSchool().parse_schoool('schools.txt')
    urls = set()

    # 将学校名称放入待抓取url列表中
    # quote将中文转url
    for key in keys:
        url = 'http://baike.baidu.com/item/' + urllib.parse.quote(key)
        urls.add(url)

    # 执行爬虫主程序
    obj_spider = SpiderMain()
    obj_spider.craw(urls)
