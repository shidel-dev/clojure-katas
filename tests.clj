(ns lists-tests
(:require [clojure.test :refer :all]))
(load-file "lists.clj")

(deftest last-box
  (is (= (lists/my-last '(a b c d)) '(d))))

(run-tests)
