lineas = ["uno", "dos", "tres"]

"""			CREACION DEL ARCHIVO 			"""
# Definimos la ubicacion
dirFichero = './text.txt' 
 # Write crea el archivo si no existe, si existe lo sobrescribe.
 # Se puede usar 'a+' en vez de 'w', para escribir sobre el mismo archivo
 # la escritura empieza desde lo ultimo
fichero = open(dirFichero, 'w+')

# Se llena el fichero con .write()
for i in range (0, len(lineas) ):
	fichero.write(lineas[i] + '\n')
fichero.close()

""" 		LECTURA DEL ARCHIVO 			"""
# Se puede usar 'w+' que tras leer su contenido lo borra.
# Se puede abrir el archivo y usar .read() - .readline(). Siempre cerrar archivo abierto.
with open(dirFichero, 'r') as reader:
	for line in reader:
		print (line)
