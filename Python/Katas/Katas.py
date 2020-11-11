
# 7 kyu kata, Remove url anchor
def remove_url_anchor(url):
	if ("#" in url):
		index = url.rfind("#")
		return url[0:index]
	else:
		return url

# 7 kyu kata, Sum of numbers from 0 to n
def show_sequence(n):
	if n < 0:
		return f"{n}<0"
	m = 0
	s = ""
	for num in range(0, n):
		m += num
		s += f"{num}+"
	m += n
	s += f"{n}"
	return f"{n}={n}" if n == 0 else s+f" = {m}"

# 7 kyu kata, Find the stray number
def stray(arr):
	el = 0
	ol = 0
	elc = 0
	olc = 0
	for x in arr:
		if (el == 0):
			el = x
		if (x != el):
			ol = x
			olc += 1
		if (x != ol):
			elc += 1
	return el if elc < olc else ol

# 5 kyu kata, Regex password validation
#regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$"