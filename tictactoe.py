def print_game(list):
    print('-' * 9)
    for i in range(len(list)):
        string = "| "
        for j in range(len(list[i])):
            string += list[i][j] + ' '
        string += "|"
        print(string)
    print('-' * 9)


def check(list):
    result = []
    for i in range(len(list)):
        if list[i][0] == list[i][1] == list[i][2]:
            result.append(list[i][0])
        if list[0][i] == list[1][i] == list[2][i]:
            result.append(list[0][i])
    if list[0][0] == list[1][1] == list[2][2]:
        result.append(list[0][0])
    if list[0][2] == list[1][1] == list[2][0]:
        result.append(list[0][2])
    if ' ' in result:
        result.remove(' ')
    if len(result) == 1:
        return result.pop()
    else:
        return False


def input_coordinates(list):
    x, y = input().split()
    try:
        x = int(x) - 1
        y = int(y) - 1
    except TypeError:
        print("You should enter numbers!")
    else:
        if 0 > x or x > 2 or 0 > y or y > 2:
            print("Coordinates should be from 1 to 3!")
        elif list[x][y] != ' ':
            print("This cell is occupied! Choose another one!")
        else:
            return x, y
    return -1, -1


game_over = ['Draw', 'Game not finished', 'Impossible']
XO = "XO"
game = [[' ' for _ in range(3)] for _ in range(3)]
print_game(game)
for i in range(9):
    x, y = -1, -1
    while x < 0 and y < 0:
        x, y = input_coordinates(game)
    game[x][y] = XO[i % 2]
    print_game(game)
    res = check(game)
    if str(res) in "XO":
        break
if str(res) in XO:
    print(f"{res} wins")
else:
    print("Draw")

