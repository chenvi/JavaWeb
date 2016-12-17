class HtmlOutputer(object):
    def __init__(self):
        self.datas = []

    def collect(self, data):
        if data is None:
            return
        self.datas.append(data)

    def output_html(self):
        fout = open('output.html','w',encoding='utf-8')

        fout.write("<html>")
        fout.write("<body>")
        fout.write("<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\">")

        fout.write("<tr>")
        fout.write("<td>地址</td>")
        fout.write("<td>标题</td>")
        fout.write("<td>信息</td>")
        fout.write("</tr>")
        for data in self.datas:
            fout.write("<tr>")
            fout.write("<td>%s</td>" % data['url'])
            fout.write("<td>%s</td>" % data['title'])
            fout.write("<td>%s</td>" % data['summary'])
            fout.write("</tr>")

        fout.write("</table>")
        fout.write("</body>")
        fout.write("</html>")

        fout.close()