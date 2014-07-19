(ns rle)


(defn split-and-reduce [str-seq]
  (let [first-char (first str-seq)
        split-seq (split-with #(= first-char %) str-seq)
        match (split-seq 0)]
    (assoc split-seq 0 [(count match) (first match)])))


(defn encode [string]
  (loop [str-seq (seq string) counts []]

    (if (empty? str-seq) (clojure.string/join counts)

      (let [tail-and-count (split-and-reduce str-seq)
            tail (tail-and-count 1)
            letter-count ((tail-and-count 0) 0)
            letter ((tail-and-count 0) 1) ]

      (recur tail (-> counts
                      (conj letter-count)
                      (conj letter)))))))


(defn parse-int [s]
   (Integer. (re-find  #"\d+" s )))

(defn pair-up-totals [string]
 (map vector
    (map parse-int (clojure.string/split string #"\D"))
    (remove clojure.string/blank? (clojure.string/split string #"\d"))))

(defn build-str-seq [pair]
  (take (first pair) (repeat (second pair))))


(defn decode [string]
  (let [letter-totals (pair-up-totals string)]
     (-> (map build-str-seq letter-totals)
         flatten
         clojure.string/join)))




