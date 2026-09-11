class Solution:
    def isPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s) - 1

        #.,
        while (left <= right):
            #s[left] = '.'
            #s[right] = ,
            while(not s[left].isalnum() and left < right):
                left += 1
            #s[left] = 'n'
            
            while(not s[right].isalnum() and left < right):
                right -= 1
                
            if(s[left].lower() != s[right].lower()):
                return False
            
            left += 1
            right -= 1

        return True