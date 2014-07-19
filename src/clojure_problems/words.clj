(ns words)
(use 'clojure.java.io)

(defn get-lines [fname]
  (with-open [r (reader fname)]
    (doall (line-seq r))))

(defn divide [list]
  (partition-all (/ (count list) 4) list))

(defn inc-letters [word results]
  (merge-with + (frequencies word) results))

(defn conquer [word-seq]
  (loop [words word-seq results {}]
    (if (empty? words) results
      (recur (rest words) (inc-letters (first words) results)))))

(defn index-letters [fname]
  (reduce (fn [total-results results] (merge-with + total-results results))
    (let [chunks (-> fname (get-lines) (divide))]
      (pvalues (conquer (nth chunks 0))
               (conquer (nth chunks 1))
               (conquer (nth chunks 2))
               (conquer (nth chunks 3))))))

(index-letters "resources/words.txt")

