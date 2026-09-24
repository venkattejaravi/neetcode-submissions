class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x : x[0])

        merged_lists = []

        for start, end in intervals:
            if not merged_lists:
                merged_lists.append([start, end])
            else:
                if start <= merged_lists[-1][1]:
                    merged_lists[-1][1] = max(merged_lists[-1][1], end)
                else:
                    merged_lists.append([start, end])


        return merged_lists
