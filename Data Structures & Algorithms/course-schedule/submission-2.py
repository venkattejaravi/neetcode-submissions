class Solution:
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        from collections import deque
        indegrees = defaultdict(int)

        for i in range(numCourses):
            indegrees[i] = 0


        adjList = defaultdict(list)

        for course, preReq in prerequisites:
            adjList[preReq].append(course)
            indegrees[course] += 1

        # Apply khan’s algorithm
        q = deque()

        for course, indegree in indegrees.items():
            if not indegree:
                q.append(course)

        coursesCompleted = 0
        while q:
            course = q.popleft()
            coursesCompleted += 1
            for dep_course in adjList[course]:
                indegrees[dep_course] -= 1
                if not indegrees[dep_course]:
                    q.append(dep_course)

        return coursesCompleted == numCourses
