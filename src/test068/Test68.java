package test068;
// 프로그래머스 Level2 전화번호 목록
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Test68 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] input = {"123", "456", "789"};
		boolean output = sol.solution(input);
		System.out.println(output);
	}
}

//정렬 후 비교
//class Solution {
//    public boolean solution(String[] phone_book) {
//    	boolean answer = true;
//    	
//        Arrays.sort(phone_book);
//
//        for(int i = 0; i < phone_book.length - 1; i++) {
//        	if(phone_book[i + 1].startsWith(phone_book[i])) {
//        		answer = false;
//        		break;
//        	}
//        }
//        
//        return answer;
//    }
//}

// Trie
class Solution {
    public boolean solution(String[] phone_book) {
    	boolean answer = true;
    	Trie trie = new Trie();
    	
        for(String s : phone_book) {
        	trie.insert(s);
        }
        
        for(String s : phone_book) {
        	TrieNode trieNode = trie.find(s);
        	if(trieNode != null) {
        		if(trieNode.getChildNodes().size() > 0) {
        			answer = false;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}

class Trie {
	TrieNode rootNode;
	
	Trie() {
		this.rootNode = new TrieNode();
	}
	
	void insert(String s) {
		TrieNode thisNode = this.rootNode;
		
		for(int i = 0; i < s.length(); i++) {
			if(thisNode.getChildNodes().get(s.charAt(i)) == null) {
				thisNode.childNodes.put(s.charAt(i), new TrieNode());
			}
			
			thisNode = thisNode.getChildNodes().get(s.charAt(i));
		}
	}
	
	TrieNode find(String s) {
		TrieNode thisNode = this.rootNode;
		
		for(int i = 0; i < s.length(); i++) {
			if(thisNode.getChildNodes().get(s.charAt(i)) == null) {
				return null;
			}
			thisNode = thisNode.getChildNodes().get(s.charAt(i));
		}
		
		return thisNode;
	}
}

class TrieNode {
	Map<Character, TrieNode> childNodes = new HashMap<>();
	
	Map<Character, TrieNode> getChildNodes() {
		return this.childNodes;
	}
}