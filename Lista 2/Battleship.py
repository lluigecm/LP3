def main():
    print("Welcome to Battleship".center(100))
    player1 = create_board()
    player2 = create_board()
    p1_target = create_board()
    p2_target = create_board()


    put_ships(player1, 1)
    pretty_print(player1)
    put_ships(player2, 2)
    pretty_print(player2)

    while(True):
        attack(1,2,player2,p1_target)
        if(winner(player2)):
            print("PLAYER 1 WINS! YOU SUNK ALL OF YOUR'S OPPONENTS SHIPS")
            break
        attack(2,1,player1,p2_target)
        if(winner(player1)):
            print("PLAYER 2 WINS! YOU SUNK ALL OF YOUR'S OPPONENTS SHIPS")
            break
    print("Final Boards: ")
    pretty_print(player1)
    pretty_print(player2)

    
def winner(player_board: list[list]):
    ships = 0
    for lin in player_board:
        ships += lin.count('@')
    return ships == 0

def attack(player: int, player_enemy: int, player_target: list[list], player_hist: list[list]):
    print(f"Player {player}, enter hit row/column: ")
    while True:
        lin, col = map(int, input().split())
        if lin < 0 or lin > 4 or col > 4 or col < 0:
            print("Invalid coordinates. Choose different coordinates")
        elif player_hist[lin][col] == 'O' or player_hist[lin][col] == 'X':
            print("You already have on this spot. Choose different coordinates.")
        else:
            if player_target[lin][col] == '@':
                player_target[lin][col] = 'X'
                player_hist[lin][col] = 'X'
                print(f"PLAYER {player} HIT PLAYER {player_enemy}'s SHIP")
                pretty_print(player_hist)
                break
            else:
                player_target[lin][col] = 'O'
                player_hist[lin][col] = 'O'
                print("PLAYER {player} MISSED")
                pretty_print(player_hist)
                break


def pretty_print(player_board: list[list]):
    for i in range(5):
        print(" ".join(player_board[i]))


def put_ships(player_board: list[list], player: int):
    ships = 0
    print(f"PLAYER {player} ENTER YOUR SHIP'S COORDINATES: ")
    while True:
        print(f"Enter ship {ships +1} coordinate: ")
        lin, col = map(int, input().split())
        if lin < 0 or lin > 4 or col > 4 or col < 0:
            print("Invalid coordinates. Choose different coordinates")
        elif player_board[lin][col] == '@':
            print("You already have a sip there. Choose different coordinates")
        else:
            player_board[lin][col] = '@'
            ships += 1
            if ships == 5:
                break


def create_board():
    return [['_' for i in range(5)] for i in range(5)]

main()