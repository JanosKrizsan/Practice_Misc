
def add1(x, y):
	return x + y

class Adder:
	def __call__(self, x, y):
		return x + y

add2 = Adder()

def compute():
	rv = []
	for i in range(10):
		sleep(.5)
		rv.append(i)
	return rv

class Compute:
	def __call__(self):
		rv = []
		for i in range(10):
			sleep(.5)
			rv.append(i)
		return rv

	def __iter__(self):
		self.last = 0
		return self

	def __next__(self):
		rv = self.last
		self.last += 1
		if self.last > 10:
			raise StopIteration('Stop')
		sleep(.5)
		return rv


for val in Compute():
	print(val)

def generator():
	for i in range(10):
		sleep(.5)
		yield i
