def solution(players, m, k):
    servers = {}
    
    result = 0
    for i in range(len(players)):
        if i in servers:
            servers.pop(i)
        current_available = sum(servers.values()) * m
        if players[i] > current_available:
            scale = (players[i] - current_available) // m
            servers[i + k] = scale
            result += scale
    return result
