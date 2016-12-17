# 主程序
import urllib.parse

from spider import html_downloader
from spider import html_outputer
from spider import html_parser
from spider import url_manager


class SpiderMain(object):
    # 构造函数
    def __init__(self):
        self.urls = url_manager.UrlManager()
        self.downloader = html_downloader.HtmlDownloader()
        self.parser = html_parser.HtmlParser()
        self.outputer = html_outputer.HtmlOutputer()

    # 爬虫函数
    def craw(self, root_url, deep):
        count = 1
        self.urls.add_new_url(root_url)
        while self.urls.has_new_url():
            try:
                new_url = self.urls.get_new_url()
                print('craw %d : %s'%(count,new_url))
                html_cont = self.downloader.download(new_url)
                new_urls, new_data = self.parser.parse(new_url,html_cont)
                self.urls.add_new_urls(new_urls)
                self.outputer.collect(new_data)
                if count == deep:
                    break
                count = count + 1

            except:
                print('craw error!')



        self.outputer.output_html()


if __name__ == "__main__":
    key = input("请输入词条：")
    deep = int(input("请输入爬虫深度："))
    # quote将中文转url
    root_url = 'http://baike.baidu.com/item/'+urllib.parse.quote(key)
    obj_spider = SpiderMain()
    obj_spider.craw(root_url,deep)
