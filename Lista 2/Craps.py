import random

ponto = -1
lancamento = 1

while(1):
    soma = 0
    random.seed()
    dado1 = int(random.randrange(0,7,))
    dado2 = int(random.randrange(0,7,))

    soma = dado1 + dado2
    
    if lancamento == 2:
        print("Iniciando estagio 2")
    if lancamento == 1:
        print(f"Dado 1: {dado1} --- Dado 2: {dado2}")
    else: 
        print(f"Jogada {lancamento}: {soma}")

    if (lancamento == 1 and soma != 7 and soma > 3 and soma < 11):
        ponto = soma
        print(f"Ponto: {ponto}")
    
    if((soma == 7 or soma == 11) and lancamento == 1):
        print("Voce venceu!!!")
        break
    elif (lancamento != 1 and soma == ponto):
        print("Voce venceu!!!")
        break
    
    if (soma == 2 or soma == 3 or soma == 12 or (soma == 7 and lancamento !=1)):
        print("Voce perdeu!!!")
        break
    
    lancamento+=1