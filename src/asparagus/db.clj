(ns asparagus.db
    (:require [korma.db :refer [defdb mysql]]
              [environ.core :refer [env]]
              [asparagus.config :refer [config]]))

(defdb db
  (let [db-conf (:db (config (env :config "config.edn")))]
    (mysql {:db "asparagus"
            :user (:user db-conf)
            :password (:password db-conf)
            :host (:host db-conf)
            :port (:port db-conf)})))

