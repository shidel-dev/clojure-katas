(ns math)

(defn gcd [n1 n2]
  (loop [a n1 b n2]
    (if (zero? b) a (recur b (mod a b)))))


(defn coprime [a b]
  (= (gcd a b) 1))
