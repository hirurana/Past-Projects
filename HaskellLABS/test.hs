-- @Author: hiru
-- @Date:   2017-12-05T19:28:04+00:00
-- @Last modified by:   hiru
-- @Last modified time: 2017-12-07T09:43:21+00:00
import Data.Char
import Test.QuickCheck

biggestCube :: Int
biggestCube = head [x | x <- [10000,9999..], x^3 < 10000]

insert :: Int -> [Int] -> [Int]
insert n (x:xs) | n > x = x : insert n xs
                | otherwise = [n] ++ (x:xs)

capitalised :: String -> String
capitalised [] = []
capitalised (x:xs) = toUpper x : capitalised xs

length1 :: [a] -> Int
length1 xs = sum [1 | x <- xs]

length2 :: [a] -> Int
length2 xs = sum $ map (\x -> 1) xs

prop_positive :: [a] -> Bool
prop_positive xs = length1 xs >= 0 && length2 xs >= 0
