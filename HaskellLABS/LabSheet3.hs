-- @Author: hiru
-- @Date:   2017-11-27T11:19:45+00:00
-- @Last modified by:   hiru
-- @Last modified time: 2017-11-27T19:46:47+00:00
mult :: [Int] -> Int
mult xs = foldr (*) 1 xs

posList :: [Int] -> [Int]
posList xs = filter (>0) xs

trueList :: [Bool] -> Bool
trueList xs = foldr (&&) True xs

evenList :: [Int] -> Bool
evenList xs = trueList $ map even xs

maxList :: (Ord a) => [a] -> a
maxList [] = error "max of empty list"
maxList [x] = x
maxList (x:xs)
  | x > maxTail = x
  | otherwise = maxTail
  where
    maxTail = maxList xs

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b xs = filter (\x -> x >= a && x <= b) xs

countPositives :: (Ord a, Num a) => [a] -> Int
countPositives xs = length $ filter (>0) xs

myLength :: [a] -> Int
myLength xs = foldr (+) 0 $ map (\x -> 1) xs

myMap :: (a -> b) -> [a] -> [b]
myMap func xs = foldr (\x list -> func x : list) [] xs

myLength' :: [a] -> Int
myLength' xs = foldr (\x list -> 1 + list) 0 xs
