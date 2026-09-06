class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = defaultdict(list)
        for str in strs:
            sorted_str = "".join(sorted(str))
            if(sorted_str not in result):
                result.setdefault(sorted_str, [str])
            else:
                result.get(sorted_str).append(str)

        return list(result.values())
