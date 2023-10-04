import sqlite3

database = "database.db"

class DataBase:
    def ejecutar_consulta(self,consulta,parametros= ()):
        with sqlite3.connect(database) as conn:
            self.cursor = conn.cursor()
            result = self.cursor.execute(consulta,parametros)
            conn.commit()
            return result 
