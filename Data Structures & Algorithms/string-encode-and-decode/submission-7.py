class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + '#' + s        
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        j = 0
        while j < len(s):
            if s[j] == '#':
                len_str = int(s[i:j])
                res.append(s[j+1 : j + len_str + 1])
                i = j + len_str + 1
                j = j + len_str + 1
            else:
                j += 1
        return res
