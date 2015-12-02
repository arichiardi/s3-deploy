(set-env!
 :source-paths   #{"src"}
 :dependencies '[[adzerk/bootlaces "0.1.11" :scope "test"]
                 [org.clojure/clojure "1.7.0" :scope "provided"]
                 [prismatic/schema "1.0.3"]
                 [amazonica/amazonica "0.3.33"]
                 [com.novemberain/pantomime "2.7.0" :exclusions [org.apache.httpcomponents/httpcore]]
                 [digest "1.4.4"]])

(require '[adzerk.bootlaces :refer [bootlaces! build-jar push-snapshot push-release]])

(def +version+ "0.1.0-SNAPSHOT")
(bootlaces! +version+)

(task-options!
 pom {:project     'confetti/s3-deploy
      :version     +version+
      :description "Push things to S3, but be lazy about it."
      :url         "https://github.com/confetti-clj/s3-deploy"
      :scm         {:url "https://github.com/confetti-clj/s3-deploy"}})
