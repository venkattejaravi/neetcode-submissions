class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        seen = {}

        for i in range(len(numbers)):
            y = target - numbers[i]
            if y in seen.keys():
                return [seen[y] + 1, i + 1]
            else:
                seen[numbers[i]] = i

        return []	



        