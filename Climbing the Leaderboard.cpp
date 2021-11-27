vector<int> climbingLeaderboard(vector<int> ranked, vector<int> player) {
    auto result = vector<int>();
    auto mset = set<int>();
    
    for (const auto& r : ranked) {mset.insert(r);}
    
    auto it = mset.begin();
    auto rank = mset.size() + 1;
    
    for (const auto& score : player) {
        while(true) {
            if(it == mset.end()) {
                break;
            }
            
            if(*it > score) {
                break;
            }
            
            rank--;
            it++;
        }

        result.push_back(rank);
    }
    
    return result;
}
