
def timer(func, x, y):
	def f(*args, **kwargs):
		before = time()
		rv = func(*args, **kwargs)
		after = time()
		print('elapsed', after - before)
		return rv
	return f

def ntimes(n):
	def inner(f):
		def wrapper(*args, **kwargs):
			for _ in range(n):
				rv = f(*args, **kwargs)
				return rv
			return wrapper
	return inner

@timer
@ntimes(15)
def add(x, y):
	return x + y

@timer
@ntimes(3)
def sub(x, y):
	return x - y

print('add(10)', add(10))
print('add(20, 30)', add(20, 30))
print('add("a", "b")', add("a", "b"))

