class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        merged_intervals = []

        placed = False

        for i in range(len(intervals)):
            if intervals[i][1] < newInterval[0]:
                merged_intervals.append(intervals[i])
            elif intervals[i][0] > newInterval[1]:
                merged_intervals.append(newInterval)
                merged_intervals.extend(intervals[i:])
                placed = True
                break
            else:
                newInterval = [min(intervals[i][0], newInterval[0]), max(intervals[i][1], newInterval[1])]


        
        if not placed:
            merged_intervals.append(newInterval)

        return merged_intervals
