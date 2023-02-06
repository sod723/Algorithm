n,m = map(str,input().split())
n_r=n[::-1]
m_r=m[::-1]
print(max(int(n_r),int(m_r)))