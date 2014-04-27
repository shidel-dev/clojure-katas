(ns lists-tests
(:require [clojure.test :refer :all]))
(load-file "lists.clj")

(deftest last-box
  (is (= (lists/my-last '(a b c d)) '(d))))

(deftest last-plus-one-box
  (is (= (lists/my-but-last '(a b c d)) '(c d))))

(deftest palindrome
  (is (= (lists/is-palindrome '(a b c b a)) true))
  (is (= (lists/is-palindrome '(a b c b z)) false)))


(deftest compress
   (is (= (lists/compress '(a a a a b c c a a d e e e e)) '(a b c a d e))))


(run-tests)

