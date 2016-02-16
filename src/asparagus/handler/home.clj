(ns asparagus.handler.home
  (:require [ring.util.response :refer [response]]
            [selmer.parser :refer [render-file]]
            [ring.middleware.json :refer [wrap-json-response wrap-json-params]]
            ))

(defn index [request]
  (response (render-file "home/index.html" {:message "Hello World"})))

(defn test [request]
  (response (render-file "home/test.html" {:message "test"})))

(defn json [request]
  (response {:foo :bar}))

(defn user [request]
  (let [id (get-in request [:params :id])]
   (response {:id id})))

(defn user2 [request]
  (let [id (get-in request [:path-params :id])]
    (response {:id id})))

(def json
  (wrap-json-response json))

(def user
  (wrap-json-response (wrap-json-params user)))

(def user2
  (wrap-json-response (wrap-json-params user2)))
