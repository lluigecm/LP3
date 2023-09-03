import math
volt= []
media = 0; variancia = 0

print("Insira as medicoes de voltagem a seguir\n")


for i in range(10):
    med = float(input(f"{i+1} Leitura: "))
    volt.append(med)
    media += volt[i]

media /= 10
print(f"Media: {media}")

for i in range(10):
    variancia += pow(volt[i] - media, 2)
variancia /= 10;

desvioP = math.sqrt(variancia) 
print(f"Desvio Padrao: {desvioP}")

if (desvioP > (0.1*media)):
    print("O multimetro nao esta operando da maneira correta e não deve ser utilizado")
else:
    print("O multimetro esta funcionando corretamente e pode ser utilizado")