import conexion as conn


db = conn.DataBase()

def create_user():
    name = str(input("Nombre: "))
    email = str(input("Correo electrónico: "))
    rfc = str(input("RFC: "))
    phone = int(input("Número de telefono: "))
    obs = str(input("Observaciones: "))
    if len(rfc) == 12:
        if(len(name) > 0 and len(rfc) > 0):
            query= "insert into cliente(nombre,rfc,tel,email,observaciones) VALUES(?,?,?,?,?)"
            valores = (name,rfc,phone,email,obs)
            db.ejecutar_consulta(query,valores)
            print("cliente creado...")
    else:
        print("Error en el RFC ingresado")

def read_user():
    result = db.ejecutar_consulta("SELECT * FROM cliente")
    result= result.fetchall()
    if len(result)>0:
        for result in result:
            print(result)

def update_user():
    rfc = str(input("Ingrese el RFC del cliente"))
    name = str(input("Nombre: "))
    email = str(input("Correo electrónico: "))
    phone = int(input("Número de telefono: "))
    obs = str(input("Observaciones: "))
    if len(rfc) > 0 :
        query= "UPDATE cliente SET nombre=?,tel=?,email=?,observaciones=? WHERE rfc= ?"
        valores = (name,phone,email,obs,rfc)
        db.ejecutar_consulta(query, valores)
        print("Datos actualizados...")

def delete_user():
    rfc = str(input("Ingrese el RFC del cliente"))
    if len(rfc) > 0 :
        query= "DELETE FROM cliente WHERE rfc = ?"
        valores = (rfc,)
        db.ejecutar_consulta(query, valores)
        print("Cliente eliminado...")
opt = 0

while opt !=5:
    print("\n          CRUD          \n")
    print("\n    1. INSERTAR CLIENTE         ")
    print("\n    2. LISTAR CLIENTES      ")
    print("\n    3. MODIFICAR REGISTROS      ")
    print("\n    4. ELIMINAR CLIENTE      \n")
    print("\n    5. SALIR      \n")

    opt = int(input("Seleccione una opción: "))


    if(opt == 1):
        create_user()
    elif(opt == 2):
        read_user()
    elif(opt == 3):
        update_user()
    elif(opt == 4):
        delete_user()