import urllib.parse
from bs4 import BeautifulSoup
import re
class HtmlParser(object):
    def _get_new_urls(self, url, soup):
        new_urls = set()

        links = soup.find_all('a',href=re.compile(r"/view/\d+\.htm"))
        for link in links:
            new_url = link['href']
            new_full_url = urllib.parse.urljoin(url,new_url)
            new_urls.add(new_full_url)
        return new_urls

    def _get_new_data(self, url, soup):
        data = {}

        title = soup.find('dd',class_="lemmaWgt-lemmaTitle-title").find('h1')
        data['title'] = title.get_text()

        summary = soup.find('div',class_ ="lemma-summary")
        data['summary'] = summary.get_text()

        # 将url转中文
        data['url'] = urllib.parse.unquote(url,encoding='utf-8')

        return data

    def parse(self, url, html_cont):
        if url is None or html_cont is None:
            return

        soup = BeautifulSoup(html_cont,'html.parser')
        new_urls = self._get_new_urls(url,soup)
        new_data = self._get_new_data(url,soup)
        return new_urls,new_data

