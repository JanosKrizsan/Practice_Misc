from dis import dis
import builtins


class BaseMeta(type):
		def __new__(cls, name, bases, body):
			if name != 'Base' and not 'bar' in body:
				raise TypeError("bad user class")
			return super().__new__(cls, name, bases, body)
	

class Base(metaclass=BaseMeta):
	def foo(self):
		return 'foo'

	def __init_subclass__(cls, *a, **kw):
		print('init_subclass', a, kw)
		return super().__init_sublass__(cls, *a, **kw)

old_bc = __build_class__
def my_bc(func, name, base=None, **kw):
	if base is Base:
		print('check if bar method is defined')
	if base is not None:
		return old_bc(func, name, base, **kw)
	return old_bc(func, name, **kw)

builtins.__build_class__ = my_bc

dis(Base)