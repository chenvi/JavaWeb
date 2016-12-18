class ParseSchool(object):

    def parse_schoool(self,filepath):
        sch = set()
        f = open(filepath, 'r', encoding='utf-8')
        lines = f.readlines()
        for line in lines:
            schools = line.split(' ')
            for school in schools:
                if school.__contains__('大学') or school.__contains__('学院'):
                    print(school.replace('\n',''))
                    sch.add(school.replace('\n',''))
        print('211大学总共有' + '%d' % len(sch) + '所')
        f.close()
        return sch