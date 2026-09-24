class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)

        intervals.sort(key = lambda x : x[0])

        merged_intervals = [intervals[0]]

        for i in range(len(intervals)):
            start = intervals[i][0]
            end = intervals[i][1]
            
            if start <= merged_intervals[-1][1]:
                merged_intervals[-1][1] = max(merged_intervals[-1][1], end)
            else:
                merged_intervals.append(intervals[i])

        return merged_intervals
