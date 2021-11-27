string isValid(string str) {
    if (str.size() <= 2) return "YES";
    auto mvec = vector<int>(26, 0);
    
    for(const auto& s : str) mvec[s - 'a']++;
        
    for (auto it = mvec.begin(); it != mvec.end();)
        if (*it == 0) {it = mvec.erase(it);} 
        else {++it;}
        
    sort(mvec.begin(), mvec.end());
    
    auto first = mvec.begin();
    auto last = mvec.end() - 1;
    
    if( *first == *last ) return "YES";
    if( *first == *(last - 1) && *(last - 1) == *last - 1) return "YES";
    if( *(first + 1) == *last && *first == 1) return "YES";

    return "NO";
}
