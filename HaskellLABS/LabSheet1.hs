-- @Author: hiru
-- @Date:   2017-11-17T14:31:50+00:00
-- @Last modified by:   hiru
-- @Last modified time: 2017-11-20T22:03:49+00:00

import Data.Char

square :: Integer -> Integer
square n = n * n

pyth :: Integer -> Integer -> Integer
pyth n m = square n + square m

isTriple :: Integer -> Integer -> Integer -> Bool
isTriple a b c = pyth a b == square c

isTripleAny :: Integer -> Integer -> Integer -> Bool
isTripleAny a b c = pyth a b == square c || pyth a c == square b || pyth b c  == square a

halfEvens :: [Int] -> [Int]
halfEvens [] = []
halfEvens xs = [if even x then div x 2 else x | x <- xs]

inRange :: Int -> Int -> [Int] -> [Int]
inRange a b xs = [x | x <- xs, x >= a && x <= b]

countPositives :: [Int] -> Int
countPositives [] = 0
countPositives xs = length [x | x <- xs, x > 0]

capitalised :: String -> String
capitalised (x:xs) = [toUpper x] ++ [toLower a | a <- xs]

title :: [String] -> [String]
title xs = [capitalised x | x <- xs]
