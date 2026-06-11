class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        # Using Hashset
        countS, countT = {}, {}

        for i in range(len(s)):
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)

        return countS == countT
        # Time complexity: O(n + m)
        # Space Complexity: O(1)
        
        '''
        # Using Hashet but with Array
        count = [0] * 26

        for i in range(len(s)):
            count[ord(s[i]) - ord('a')] += 1
            count[ord(t[i]) - ord('a')] -= 1

        for val in count:
            if val != 0:
                return False

        return True
        # Time complexity: O(n + m)
        # Space Complexity : O(1)
        '''

        '''
        # using sort technique
        return sorted(s) == sorted(t)
        # Time complexity: O(nlogn) + O(mlogm)
        # Space Complexity : O(1) or O(n + m)

        '''