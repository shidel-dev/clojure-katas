(ns algo
  (:require [clojure.math.numeric-tower :as math]))

; WIP
(comment

(defn mid-point [list]
  (-> list
      (count)
      (/ 2)
      (math/floor)))

(defn merge* [left right]
  (loop [l left r right res '()]
    (cond
     (or (empty? l) (empty? r)) res
     :else
       (if (<= (first l) (first r))
         (recur (rest left) right (conj res (first left)))
         (recur left (rest right) (conj res (first right)))))))

(defn merge-sort [list]
  (if (< (count list) 2)
    (list)
    ((let [li (vec list)
           mid (mid-point li)
           left (take mid li)
           right (drop mid li)]
       (merge* left right)))))

)

; bubble sort

(defn swap [v i j]
  (-> v (assoc i (v j)) (assoc j (v i))))

(defn bubble-sort [v]
  (loop [vect v index 0]
    (cond
     (= index (-> vect (count) (dec)))
       vect
     (> (vect index) (vect (inc index)))
       (recur (swap vect index (inc index)) 0)
     :else
       (recur vect (inc index)))))

;Collatz Conjecture

(defn even-odd-opps [num]
   (cond
    (even? num)(/ num 2)
    (odd? num) (inc (* num 3))))

 (defn collatz [input-num]
   (loop [num input-num count 1]
     (if (= num 1) count
       (recur (even-odd-opps num) (inc count)))))



(algo/bubble-sort [3456 4 8 10000 3 9 0 2 500 4 1])





