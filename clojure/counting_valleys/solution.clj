;
; Complete the 'countingValleys' function below.
;
; The function is expected to return an INTEGER.
; The function accepts following parameters:
;  1. INTEGER steps
;  2. STRING path
;
(defn countingValleys [steps path]
  (->>
   path
   char-array
   seq
   (reduce
    (fn [{:keys [level valleys] :as a} steps]
      (let [new-level (case steps
                            \U (inc level)
                            \D (dec level)
                            level)]
        (assoc
         a
         :level new-level
         :valleys
                (if (and (zero? new-level) (= steps \U))
                  (inc valleys)
                  valleys))))
    {:level   0
     :valleys 0})
   :valleys))

(def fptr (get (System/getenv) "OUTPUT_PATH"))
(def steps (Integer/parseInt (clojure.string/trim (read-line))))
(def path (read-line))
(def result (countingValleys steps path))

(spit fptr (str result "\n") :append true)
