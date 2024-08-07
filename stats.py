import os
import matplotlib.pyplot as plt


def extract_stats(file):
    with open(file, 'r') as f:
        return [float(line.strip()) for line in f]

def plotgraph(stats):
    if os.path.exists('stats.png'):
        os.remove('stats.png')
    algos = ['bubble', 'insertion', 'merge', 'quick', 'selection']
    plt.figure(figsize=(10, 10))
    count = 0
    for key, value in stats.items():
        plt.plot(value, label=algos[count])
        count += 1
    plt.legend()
    plt.xlabel('Array Size')
    plt.ylabel('Time')
    plt.title('STATS')
    plt.savefig('stats.png')

def main():
    DIRECTORY = os.curdir + '\\src\\main\\java\\sortingalgo'
    count = 1
    stats = {}
    for i in os.listdir(DIRECTORY):
        if i.endswith('.txt'):
            stats[count] = extract_stats(DIRECTORY + "\\" + i)
            count += 1
    plotgraph(stats)

if __name__ == "__main__":
    main()