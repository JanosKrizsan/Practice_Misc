from sqlite3 import connect	
from contextlib import contextmanager

@contextmanager
def temptable(cur):
		cur.execute('create table points(x int, y int)')
		try:
			yield
		finally:
			cur.execute('drop table points')


class context_manager:
	def __init__(self, gen):
		self.gen = gen

	def __call__(self, *args, **kwargs):
		self.args, self.kwargs = args, kwargs

	def __enter__(self):
		self.gen_inst = self.gen(*self.args, self.**kwargs)
		next(self.gen_inst)

	def __exit__(self, *args):
		next(self.gen_inst, None)

with connect('test.db') as conn:
	cur = conn.cursor()
	with context_manager(temptable)(cur):
		cur.execute('create table points(x int, y int)')
		cur.execute('insert into points (x, y) values(1,1)')
		cur.execute('insert into points (x, y) values(1,2)')
		cur.execute('insert into points (x, y) values(1,3)')
		cur.execute('insert into points (x, y) values(1,4)')
		cur.execute('insert into points (x, y) values(1,5)')
		for row in cur.execute('select sum(x * y) from points'):
			print(row)
		cur.execute('drop table points')
